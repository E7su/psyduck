# Docker
```
                                                    ##        .            
                                              ## ## ##       ==            
                                           ## ## ## ##      ===            
                                       /""""""""""""""""\___/ ===        
                                  ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~   
                                       \______ o          __/            
                                         \    \        __/             
                                          \____\______/                

                                          |          |
                                       __ |  __   __ | _  __   _
                                      /  \| /  \ /   |/  / _\ | 
                                      \__/| \__/ \__ |\_ \__  |
```
## Create group without password on OS X
```
sudo visudo -s
```
```
%docker         ALL=(ALL)          NOPASSWD: ALL
```
```
sudo visudo -c
sudo dscl . append /Groups/wheel GroupMembership whale
```

## Install Docker on Debian Jessie  
```
apt-get update  
apt-get install docker.io
```
