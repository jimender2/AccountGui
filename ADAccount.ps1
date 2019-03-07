$name=$args[0]
$fname=$args[1]
$lname=$args[2]
$pword=$args[3]
$org=$args[4]
$changePass=$args[5]
$creatorusername = ""
$creatorpassword = ConvertTo-SecureString "" -AsPlainText -Force
$cred = new-object -typename System.Management.Automation.PSCredential -argumentlist $creatorusername, $creatorpassword
$secpasswd = ConvertTo-SecureString -String $pword -AsPlainText -Force
$server = 
[System.Windows.MessageBox]::Show('Hello')

New-ADuser -Name $name -GivenName $fname -Surname $lname -DisplayName $name -AccountPassword $secpasswd -Organization $org -Server $server -CannotChangePassword $changePass -Credential $cred
Set-ADUser $name -Replace @{thumbnailPhoto=([byte[]](Get-Content "accountPicture.jpg" -Encoding byte))} -Server $server -Credential $cred