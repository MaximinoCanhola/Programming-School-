def decompor(quantia:int):
    moeda = [200,100,50,20,10,5,2,1]
    final = []
    while quantia > 0:
        for i in range(len(moeda)):
            if quantia - moeda[i] >= 0:
                final.append(moeda[i])
                quantia -= moeda[i]
                break
    return final