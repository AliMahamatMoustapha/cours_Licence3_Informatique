import fetch from 'node-fetch';

const API='http://graphql.unicaen.fr:4000/';

const Sign_in=`mutation SignIn($username: String!, $password: String!) {
  signIn(username: $username, password: $password)
}`;

export function signIn_Api(username,password){
      return fetch(API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            query: Sign_in,
            variables: {
                username: username,
                password: password
            }
        })
    }
    ).then(res=>res.json());
   
}

const Sign_up=`mutation SignUp($username: String!, $password: String!) {
  signUp(username: $username, password: $password)
}`;

export function SignUp_Api(username,password){
    return fetch(API, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            query: Sign_up,
            variables: {
                username: username,
                password: password
            }
        })
    }).then(res=>res.json());
    
}
const CREATE_TODOLIST = `
mutation createTodoLists($input: [TodoListCreateInput!]!) {
  createTodoLists(input: $input) {
    todoLists {
      id
      title
    }
  }
}`;

export function createTodoLists_API(token, title, username) {
  return fetch(API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'authorization': 'Bearer ' + token
    },
    body: JSON.stringify({
      query: CREATE_TODOLIST,
      variables: {
        "input": [
          {
            "owner": {
              "connect": {
                "where": {
                  "username": username
                }
              }
            },
            "title": title
          }
        ]
      }
    })
  })
    .then(response => {
      return response.json()
    })
    .then(jsonResponse => {
      if (jsonResponse.errors != null) {
        throw jsonResponse.errors[0]
      }
      return jsonResponse.data.createTodoLists.todoLists[0]
    })
    .catch(error => {
      console.log('error API', error.message)
      throw error
    })
}
const get_TodoLists=`
 query TodoLists($where: TodoListWhere) {
  todoLists(where: $where) {
    title
    id
  }
}
`;
export async function getTodoLits(token,username){
    return await fetch(API,{
        method:"POST",
        headers:{
            'Content-Type':'application/json',
            "Authorization":"Bearer "+token
        },
        body:JSON.stringify({
            query:get_TodoLists,
            variables:{
                "where": {
                  "owner": {
                    "username": username
                  }
                }
              }
        })

    }).then(res=>res.json()).then(jres=>jres.data.todoLists);

}
const queryDeleTodoList=`mutation DeleteTodoLists($where: TodoListWhere) {
  deleteTodoLists(where: $where) {
    nodesDeleted
  }
}`;
export async function deleteTodoList_API(token,idTodolist,username){
  return await fetch(API,{
    method:"POST",
    headers:{
      'Content-Type':'application/json',
      'Authorization':'Bearer '+token
    },
    body:JSON.stringify({
      query:queryDeleTodoList,
      variables:{
        "where": {
          "id": idTodolist,
          "owner": {
            "username": username
          }
        }
      }
    })
  }).then(res=>res.json()).then(jres=>jres.data.deleteTodoLists.nodesDeleted);
}
const getTodos=`query Todos($where: TodoWhere) {
  todos(where: $where) {
    content
    done
    id
  }
}`;

export async function getTodos_Api(token,id,username){
    return await fetch(API,{
        method:"POST",
        headers:{
            'Content-Type':"application/json",
            'Authorization':'Bearer '+token
        },
        body:JSON.stringify({
            query:getTodos,
            variables:{
                "where": {
                  "belongsTo": {
                    "owner": {
                      "username": username
                    },
                    "AND": [
                      {
                        "id": id
                      }
                    ]
                  }
                }
              }
        })
    }).then(res=>res.json()).then(jres=>jres.data.todos);
}
const createTodos=`mutation CreateTodos($input: [TodoCreateInput!]!) {
  createTodos(input: $input) {
    todos {
      content
      id
      done
    }
  }
}`;
const UPDATE_TODOLIST=`mutation Mutation($where: TodoListWhere, $update: TodoListUpdateInput) {
  updateTodoLists(where: $where, update: $update) {
    todoLists {
      title
      id
    }
  }
}`;
export function updateTodoList_API(token,username,newTitle,idTodolist){
  return fetch(API,{
    method:"POST",
    headers:{
      'Content-Type':'application/json',
      'Authorization':'Bearer '+token
    },
    body:JSON.stringify({
      query:UPDATE_TODOLIST,
      variables:{
        "where": {
          "id": idTodolist,
          "owner": {
            "username": username
          }
        },
        "update": {
          "title": newTitle
        }
      }
      })

  }).then(res=>res.json()).then(jres=>jres.data.updateTodoLists.todoLists[0]);
}
export async function createTodos_Api(token,username,content,id){
    return await fetch(API,{
        method:"POST",
        headers:{
            'Content-Type':'application/json',
            "Authorization":"Bearer "+token
        },
        body:JSON.stringify({
            query:createTodos,
            variables:{
                "input": [
                  {
                    "content": content,
                    "belongsTo": {
                      "connect": {
                        "where": {
                          "id": id
                        },
                        "connect": {
                          "owner": {
                            "where": {
                              "username": username
                            }
                          }
                        }
                      }
                    }
                  }
                ]
              }
        })
    }).then(res=>res.json()).then(jres=>jres.data.createTodos.todos[0]);
}

const delTodo=`mutation DeleteTodos($where: TodoWhere) {
  deleteTodos(where: $where) {
   nodesDeleted 
  }
}`;

export async function deleteTodos(token,username,idiTodo,idiTodoBelongs){
    return await fetch(API,{
        method:"POST",
        headers:{
            'Content-Type':'application/json',
            'Authorization':'Bearer '+token
        },
        body:JSON.stringify({
            query:delTodo,
            variables:{
                "where": {
                  "id": idiTodo,
                  "belongsTo": {
                    "id": idiTodoBelongs,
                    "owner": {
                      "username": username
                    }
                  }
                }
              }
        })
    }).then(res=>res.json()).then(jres=>jres.data.deleteTodos);
}

const queryUpdateTodos=`mutation UpdateTodos($where: TodoWhere, $update: TodoUpdateInput) {
  updateTodos(where: $where, update: $update) {
    todos {
      content
      id
      done
    }
  }
}`;

export async function updateTodos(token,username,idTodos,idTodosBelongs,newText){
  return await fetch(API,{
    method:"POST",
    headers:{
      "Content-Type":"application/json",
      "Authorization":"Bearer "+token
    },
    body:JSON.stringify({
      query:queryUpdateTodos,
      variables:{
        "where": {
          "id": idTodos,
          "belongsTo": {
            "id": idTodosBelongs,
            "owner": {
              "username": username
            }
          }
        },
        "update": {
          "content": newText
        }
      }
    })
  }).then(res=>res.json()).then(jres=>jres.data.updateTodos.todos[0]);
}

const queryUpdateDone=`mutation UpdateTodos($where: TodoWhere, $update: TodoUpdateInput) {
  updateTodos(where: $where, update: $update) {
    todos {
      done
      id
    }
  }
}`;
export async function updateDone(token,username,idTodos,idiTodoBelongs,etatSwitch){
  return await fetch(API,{
    method:"POST",
    headers:{
      'Content-Type':'application/json',
      "Authorization":"Bearer "+token
    },
    body:JSON.stringify({
      query:queryUpdateDone,
      variables:{
        "where": {
          "id": idTodos,
          "belongsTo": {
            "id": idiTodoBelongs,
            "owner": {
              "username": username
            }
          }
        },
        "update": {
          "done": etatSwitch
        }
      }
    })
  }).then(res=>res.json()).then(jres=>jres.data.updateTodos.todos[0]);
}

const UPDATE_USERNAME=`mutation UpdateUsers($where: UserWhere, $update: UserUpdateInput) {
  updateUsers(where: $where, update: $update) {
    users {
      username
    }
  }
}`;
export function updatUsername_API(username,newUsenamen,token){
  return fetch(API,{
    method:"POST",
    headers:{
      'Content-Type':'application/json',
      'Authorization':'Bearer '+token
    },
    body:JSON.stringify({
      query:UPDATE_USERNAME,
      variables:{
        "where": {
          "username": username
        },
        "update": {
          "username": newUsenamen
        }
      }
    })
  })
}
const DELETE_ACOUNT=`mutation DeleteUsers($where: UserWhere) {
  deleteUsers(where: $where) {
    nodesDeleted
  }
}`;
export function DeleteAcount_API(token,usename){
  return fetch(API,{
    method:"POST",
    headers:{
      'Content-Type':'application/json',
      'Authorization':'Bearer '+token
    },
    body:JSON.stringify({
      query:DELETE_ACOUNT,
      variables:{
        "where": {
          "username": "masta"
        }
      }
    })
  });
}