$email=$args[0]
$fname=$args[1]
$lname=$args[2]
$pword=$args[3]
$org=$args[4]
$changePass=$args[5]
$group=$args[6]
gam create user $email firstname $fname lastname $lname password $pword suspended off org $org changepassword $changePass
gam update group $group add member user $email