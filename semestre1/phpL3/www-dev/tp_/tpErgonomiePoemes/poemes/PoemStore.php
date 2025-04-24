<?php
class PoemStore
{
  private $data;
  function __construct()
  {
    $this->data = array();
  }
  public function createPoem(string $id, Poem $poem)
  {
    $this->data[$id] = $poem;
  }
  public function readPoem(string $id)
  {
    if(key_exists($id,$this->data))
    {
      return $this->data[$id];
    }
    else {
      return null;
    }
  }
  public function readAllPoems()
  {
    return $this->data;
  }

}

?>
