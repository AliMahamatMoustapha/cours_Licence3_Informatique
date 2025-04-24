<?php
class Poem
{
  private $title , $imgUrl , $text , $auteur;
  function __construct($titre,$author,$textHtml,$img)
  {
    $this->title = $titre;
    $this->auteur = $author;
    $this->imgUrl = $img;
    $this->text = $textHtml;
  }
  public function getTitle(){
    return $this->title;
  }
  public function getAuthor(){
    return $this->auteur;
  }
  public function getImageUrl(){
    return $this->imgUrl;
  }
  public function getHtmlText(){
    return $this->text;
  }
}

?>
