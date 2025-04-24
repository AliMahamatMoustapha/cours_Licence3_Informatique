<!doctype html>
<html lang="fr">
<head>
  <title>Agenda</title>
  <link rel="stylesheet" href="form.css"  type="text/css" /> 
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
  <h1>Agenda</h1>
  <hr />
  <table width="100%">
  <tr>
    <td width="75%"><?php  echo $zonePrincipale; ?>  </td>
    <td style="background-color: silver;">
      <p>
        <a href="index.php?action=saisir">Saisie d'une personne</a><br />
        <a href="index.php?action=calendrier">Calendrier vide</a><br />
      </p>
    </td>
  </tr>
  </table>
  <hr />
</body>
</html>
