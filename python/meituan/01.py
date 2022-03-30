if __name__ == "__main__":
    inp = input()
    while inp:
        num = int(inp)
        if (num % 11 == 0) or (inp.count('1') >= 2):
            print('yes')
        else:
            print('no')
        inp = input()
