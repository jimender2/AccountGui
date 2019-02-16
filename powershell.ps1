$name=$args[0]
$fname=$args[1]
$lname=$args[2]
$pword=$args[3]
$org=$args[4]
$changePass=$args[5]
$creatorusername = "blrv\blrv"
$creatorpassword = ConvertTo-SecureString "blrv" -AsPlainText -Force
$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist $creatorusername, $creatorpassword
$secpasswd = ConvertTo-SecureString -String $pword -AsPlainText -Force
New-ADuser -Name $name -GivenName $fname -Surname $lname -DisplayName $name -AccountPassword $secpasswd -Organization $org -Server blrv3.blackriver.k12.oh.us -CannotChangePassword $changePass -Credential $cred