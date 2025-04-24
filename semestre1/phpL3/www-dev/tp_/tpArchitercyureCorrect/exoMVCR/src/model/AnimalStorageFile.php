<?php
require_once("AnimalStorage.php");
class AnimalStorageFile implements AnimalStorage
{
    private ObjectfileDB $db;
    public function __construct(ObjectFileDB $db)
    {
        $this->db = $db;
    }
    public function reinit()
    {
        $animalsTab = array(
        	'medor' => new Animal('Médor', 'chien', '2 ans'),
        	'felix' => new Animal('Félix', 'chat', '3 ans'),
        	'denver' => new Animal('Denver', 'dinosaure', '20 ans'),
                );
        foreach($animalsTab as $k=>$v)
        {
            $this->db->insert($v);
        }
    }
    public function read($id){
        return $this->db->fetch($id);
    }
    public function readAll(){
    return $this->db->fetchAll();
    }
}
?>