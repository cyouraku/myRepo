
memo 20170220
#check logical ethnet devices name
ls /sys/class/net/  
→ enp0s3 enp0s8 lo lxcbr0

#set /etc/nework/interfaces
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
#Try to ping 192.168.56.101 via ubuntu

#Windos VirtualBox Host-Only Network adapter setup
property > network > TCP/IPv4 > Property 
> IP: 192.168.56.10
Mask:255.255.255.0
Default Gateway: 192.168.56.255
DNS:empty
#Try to ping 192.168.56.101 via windows

