import collections

def count_elements(file):
    try:
        data = open(file)
    except IOError:
        print('File does not exist!')

    c = collections.Counter()
    mist = 0
    for line in data:
        try:
            word = line.split('\t')[7]
            c[word] += 1
        except IndexError:
            mist = mist + 1
            print('mist: ', mist)
            continue

    data.close()
    c = c.most_common()
    return c


c = count_elements('myfile.txt')
print(c)
