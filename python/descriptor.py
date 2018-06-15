import os

print("os.O_RDONLY: %s" % os.O_RDONLY)
#print("Descriptor num: %s" % os.open("test.txt",  os.O_RDONLY))
i = 0
while i < 10000000000000000000000000:
    print("Descriptor num: %s" % os.open("test.txt",  os.O_RDONLY))
    i+=1
