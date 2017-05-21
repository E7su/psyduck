# Git
```
.------------------------------------------------------------------------------.
|                             .mmMMMMMMMMMMMMMmm.                              |
|                         .mMMMMMMMMMMMMMMMMMMMMMMMm.                          |
|                      .mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm.                       |
|                    .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.                     |
|                  .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.                   |
|                 MMMMMMMM'  `"MMMMM"""""""MMMM""`  'MMMMMMMM                  |
|                MMMMMMMMM                           MMMMMMMMM                 |
|               MMMMMMMMMM:                         :MMMMMMMMMM                |
|              .MMMMMMMMMM                           MMMMMMMMMM.               |
|              MMMMMMMMM"                             "MMMMMMMMM               |
|              MMMMMMMMM                               MMMMMMMMM               |
|              MMMMMMMMM                               MMMMMMMMM               |
|              MMMMMMMMMM                             MMMMMMMMMM               |
|              `MMMMMMMMMM                           MMMMMMMMMM`               |
|               MMMMMMMMMMMM.                     .MMMMMMMMMMMM                |
|                MMMMMM  MMMMMMMMMM         MMMMMMMMMMMMMMMMMM                 |
|                 MMMMMM  'MMMMMMM           MMMMMMMMMMMMMMMM                  |
|                  `MMMMMM  "MMMMM           MMMMMMMMMMMMMM`                   |
|                    `MMMMMm                 MMMMMMMMMMMM`                     |
|                      `"MMMMMMMMM           MMMMMMMMM"`                       |
|                         `"MMMMMM           MMMMMM"`                          |
|                             `""M           M""`                              |
'------------------------------------------------------------------------------'
```

## Config
```
[user]
        name = Etsu
        email = etsu4296@gmail.com

[alias]
        home = !git config --global user.email etsu4296@gmail.com && git config --global user.name \"Etsu\"
        ivi = !git config --global user.email pazarova@ivi.ru && git config --global user.name \"pazarova\"
        alfa = !git config --global user.email pazarova@alfabank.ru && git config --global user.name \"pazarova\"

        homerepo = !git config --local user.email etsu4296@gmail.com && git config --local user.name \"Etsu\"
        ivirepo = !git config --local user.email pazarova@ivi.ru && git config --local user.name \"pazarova\"
        alfarepo = !git config --local user.email pazarova@alfabank.ru && git config --local user.name \"pazarova\"
```


## Настройка автора коммитов в git и добавление ключа
```
git config --global user.name "<name>"
git config --global user.email <email>
git config --list

ssh-keygen -t rsa -b 4096 -C "<email>"
eval "$(ssh-agent -s)"
ssh-add -K ~/.ssh/id_rsa
pbcopy < ~/.ssh/id_rsa.pub
```

## Изменение автора коммита (если нечего терять :) )
```
git log --graph
git rebase -i <hash>  # от предыдущего
git log
git commit --amend --author = "Etsu"
git rebase --continue <<email>>
git log --graph
git push --force
git log --graph
```

## For VIM!
```
sudo update-alternatives --config editor
```
