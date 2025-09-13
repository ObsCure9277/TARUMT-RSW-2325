# Install WSGI on EC2 
# Either add "sudo" before all commands or use "sudo su" first

yum install -y httpd
systemctl start httpd
systemctl enable httpd
mv aws-live /var/www/html
nano /etc/httpd/conf/httpd.conf

#go inside close this DocumentRoot
#add WSGIScriptAlias code

#DocumentRoot "/var/www/html"

WSGIScriptAlias	/ /var/www/html/aws-live/app.wsgi
<Directory /var/www/html/aws-live>
Order allow,deny
Allow from all
</Directory>

#done WSGIScriptAlias code. 
#create app.wsgi later
#save the httpd.conf and exit

# check mod wsgi
yum list available | grep mod_wsgi

# install mod wsgi
yum install python3-mod_wsgi

#go to /var/www/html/aws-live
cd /var/www/html/aws-live

#create app.wsgi
nano app.wsgi

#create app.wsgi contents
import sys

sys.path.insert(0, "/var/www/html/aws-live")

from EmpApp import app as application

#restart apache/httpd
systemctl restart httpd

#stop, start your ec2



