sudo yum -y install amazon-efs-utils
sudo mkdir /mnt/efs
sudo mount -t efs -o tls fs-04ea272fe34c4a64e:/ /mnt/efs
