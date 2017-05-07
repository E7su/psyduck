# Git

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


## Настройка автора коммитов в git и добавление ключа
git config --global user.name "<name>"
git config --global user.email <email>
git config --list

ssh-keygen -t rsa -b 4096 -C "<email>"
eval "$(ssh-agent -s)"
ssh-add -K ~/.ssh/id_rsa
pbcopy < ~/.ssh/id_rsa.pub
