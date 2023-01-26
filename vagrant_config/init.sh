#!/usr/bin/env bash

yum update
yum install wget -y

# install docker
yum install -y yum-utils

yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
yum install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin
systemctl start docker

# create user group and provide permissions
groupadd docker
usermod -aG docker vagrant
newgrp docker

#run docker service on start 
systemctl enable docker.service
systemctl enable containerd.service