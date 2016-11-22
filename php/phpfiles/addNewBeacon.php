<?php
//database settings

$post_date = file_get_contents("php://input");
$data = json_decode($post_date);

include 'connection.php';
$connect = mysqli_connect($host, $user, $pass, $database);

$query = "
	  INSERT INTO `beacons` (`id_beacon`, `name`, `author`, `year`, `description`, `image_url`, `showroom`) 
	  VALUES ('".$data->id_beacon."', '".$data->name."', '".$data->author."', '".$data->year."', '".$data->description."', '".$data->image_url."', '".$data->showroom."');";

print($query);
$result = mysqli_query($connect, $query);


while ($row = mysqli_fetch_array($result)) {
  $data[] = $row;
}
	
    //print ($data);

?>