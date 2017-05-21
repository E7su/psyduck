# ENV for training

## Install brew. Follow instructions from https://brew.sh/index_ru.html
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

## Install common utilities
```
brew install httpie ansible jfrog-cli-go git jq midnight-commander netcat socat vegeta ssh-copy-id watch zsh tmux fzf
```

## Install docker and docker env
```
brew install docker docker-compose Caskroom/cask/docker
```

## Vagrant and virtualbox and vagrant for emulate "real" environment
```
brew cask install virtualbox
brew cask install vagrant
brew cask install vagrant-manager
```
