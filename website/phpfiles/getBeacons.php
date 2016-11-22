<?php
//database settings
include 'connection.php';

$connect = mysqli_connect($host, $user, $pass, $database);

$result = mysqli_query($connect, "select * from beacons");

$data = array();
//$data = {};

while ($row = mysqli_fetch_array($result)) {
	$row_array['id_beacon'] = $row['id_beacon'];
	$row_array['name'] = $row['name'];
	$row_array['author'] = $row['author'];
	$row_array['id_name'] = str_replace(' ', '_', $row['name']);
	$row_array['year'] = $row['year'];
	$row_array['description'] = $row['description'];
	$row_array['image_url'] = $row['image_url'];
	$row_array['showroom'] = $row['showroom'];
	array_push($data, $row_array);
  	$print['object'][] = $data;
}
	//echo $print[];
    print json_encode($data);
?>