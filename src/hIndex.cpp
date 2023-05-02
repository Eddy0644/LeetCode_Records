int hIndex(int* citations, int citationsSize){
    int ac[1000]={0},maxQuote = 0,sumLeft=0;
    for(int i=0;i<citationsSize;i++){
        int j=citations[i];
        ac[j]=ac[j]+1;
        maxQuote=(maxQuote>j)?maxQuote:j;
    }
    for (int i = maxQuote; i > 0; i--) {
        if (i >= sumLeft && i <= sumLeft+ac[i]) {
            return i;
        }
        sumLeft += ac[i];
    }
    return 0;
}
int main(){

}
