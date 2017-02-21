memo 2017/02/21
#virtualbox共享文件夹
0.Install VBoxGuestAdditions,设置virtualbox的共享文件夹C:\share
1.取消virtualbox的共享文件夹自动挂载选项
2.按如下步骤操作:
sudo nano /etc/fstab
在最后加上：
share /mnt/win7shared vboxsf rw,gid=username,uid=username,auto 0 0
或者：share /mnt/win7shared vboxsf default 0 0
其中username是自己的用户名。
sudo mkdir /mnt/win7shared
sudo mount -t vboxsf  /mnt/win7shared

#ubuntu修改主机名,服务器名,用户名和密码
1.修改主机名sudo nano /etc/hostname
2.修改服务器名sudo nano /etc/hosts
3.修改用户名和密码
3.1.修改用户名
sudo nano /etc/passwd
sudo nano /etc/shadow
3.2修改用户名密码

memo 2017/02/20
#check logical ethnet devices name
ls /sys/class/net/  
→ enp0s3 enp0s8 lo lxcbr0

#set /etc/network/interfaces
#enp0s3:nat(网络地址转换)
#enp0s8:host-only
# The second network interface
auto enp0s8
iface enp0s8 inet static
address 192.168.56.101
netmask 255.255.255.0

#check physical ethnet devices
lspci | grep -i net
→ 00:03.0 Ethernet controller:****
→ 00:08.0 Ethernet controller:****

#check ifconfig ipifconfig | grep inet

#check mac address of enp0s3
ifconfig enp0s3

#check mac address of enp0s8
ifconfig enp0s8
→ 
inet addr:192.168.56.101   
Bcast:192.168.56.255   
Mask:255.255.255.0
#Try to ping 192.168.56.1 via ubuntu

#Windos VirtualBox Host-Only Network adapter setup
property > network > TCP/IPv4 > Property 
> IP: 192.168.56.1
Mask:255.255.255.0
Default Gateway: 192.168.56.255
DNS:empty
#Try to ping 192.168.56.101 via windows

