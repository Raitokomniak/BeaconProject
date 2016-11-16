<?php
//database settings

/*
$connect = mysqli_connect("localhost", "admin", "root", "beaconapp");

$post_date = file_get_contents("php://input");
$data = json_decode($post_date);


$query = "select * from beacons";
$result = mysqli_query($connect, $query);


echo $query;

while ($row = mysqli_fetch_array($result)) {
  $data[] = $row;
  
}
   	print json_encode($row);
    //print ($data);*/


//$connect = mysqli_connect("localhost", "admin", "root", "beaconapp");
$connect = mysqli_connect("mysli.oamk.fi", "t4toan00", "3u4ctzSWUr8qUPJ6", "opisk_t4toan00");

//$post_date = file_get_contents("php://input");
//$data = json_decode($post_date);


$id_beacon = $_GET['id_beacon'];
$result = mysqli_query($connect, "select * from beacons where id_beacon=".$id_beacon);

$resultdata = array();

while ($row = mysqli_fetch_array($result)) {
	$row_array['id_beacon'] = $row['id_beacon'];
	$row_array['name'] = $row['name'];
	$row_array['author'] = $row['author'];
	$row_array['year'] = $row['year'];
	$row_array['description'] = $row['description'];
	
	array_push($resultdata, $row_array);
  	$print['object'][] = $resultdata;
}
	//echo $print[];
    print json_encode($resultdata);
?>