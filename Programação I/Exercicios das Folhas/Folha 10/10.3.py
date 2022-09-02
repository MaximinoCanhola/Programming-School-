def bagdiff(xs:list,ys:list):
    for i in range(len(ys)):
        for j in range(len(xs)):
            if xs[j] == ys[i]:
                del xs[j]
                break
            else:
                continue
    return xs