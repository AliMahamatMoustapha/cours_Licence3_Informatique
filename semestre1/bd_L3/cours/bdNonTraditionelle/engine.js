var tab1 = [1, 2, 3, 4];

// returns the intersection between two arrays
function intersection(tab1, tab2) {
// assuming tab1 and tab2 are sorted
    var ret = [];

    var i = 0;
    var j = 0;

    while (i < tab1.length && j < tab2.length) {
        if (tab1[i] == tab2[j]) {
            ret.push(tab1[i]);
            i++;
            j++;
        } else if (tab1[i] < tab2[j])
            i++;
        else
            j++;
    }
    return ret;
}

// computes the norm of the vector v
function norm(v){
}

// computes the cosinus of the angle (v1, v2)
function cosinus(v1, v2){
}

function QueryEngine(query, termCollection, pageCollection) {
    /// the query string, e.g. "poste machine learning"
    this.query = query;
    /// the array of the matching documents
    this.result = Array();
    /// tells if the result has not been computed
    this.empty = true;
    /// the collection of terms
    this.termCollection = termCollection;
    /// the collection of pages
    this.pageCollection = pageCollection;
    /// the vector of DF for the query
    this.queryVector = []
    

    // add the elements of tab in this.result with interseciotn
    this.addResult = function addResult(tab) {
        if (this.empty){
            this.result = tab;
            this.empty = false;
        }else
            this.result = intersection(this.result, tab);
    }

    // computes the vector of DF of the words of the query
    this.computeQueryVector = function(words){
	words.forEach(
	    (w) => {
		var index = db.getCollection(this.termCollection).findOne({_id: w});
		this.queryVector.push(index.index.length)
	    }
	);
	//print(this.queryVector);
    }

    // compute the vector of TF-iDF of each word of the query regarding the pageId
    this.computeVector = function(pageId, words){
	let vector = []
	let q = 0;
	let page = db.getCollection(this.pageCollection).findOne({_id: pageId + ""})
	for(w in page.words)
	    if (page.words[w].word == words[q]) {
		vector.push(page.words[w].tfidf);
		q ++;
		if (q == words.length) break
	    }
	return vector;
    }

    // executes the query
    this.buildQuery = function(){
        var words = this.query.split(" ").sort();

	this.computeQueryVector(words);

	// computes the list of the index for each word (with a find( ... $or ))
        var or = Array();
        for (var i = 0; i < words.length; i ++)
	    or.push({"_id": words[i]});
        var cur = db.getCollection(this.termCollection).find({$or:or});
	// computes the intersection of each index
        while (cur.hasNext()){
            var next = cur.next();
            //print(next.index.length);
            this.addResult(next.index);
        }
        //print(this.result);
	// computes the cosinus of each vector with the query vector
	this.result.forEach((r) => {
	    print(r + " => " + cosinus(this.computeVector(r, words), this.queryVector));
	})
    }

    this.toString = function toString() {
        return "{query:" + this.query + "}";
    }
}

//var collection = db.getCollection("terms");
//print(collection.count());

var query = new QueryEngine("poste machine learning", "terms", "pages");
print(query.toString());
print("the result is : ")
print("(page) => (cosinus)")
query.buildQuery();

//print(query.result);
