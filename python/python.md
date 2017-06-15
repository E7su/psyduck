## Install virtualenv on python2
```
python2 -m pip install virtualenv
virtualenv --python=/usr/bin/python2.6 venv
```

## Activate venv
```
source venv/bin/activate
```
## Install requirements
```
pip install -r requirements.txt
```

## Run autotests
```
python -m pytest -v tests/test_generator.py
```

