
class Solution {
    public static String printBin(double num) {
        Boolean[] layers=new Boolean[32];
        for (int i = 31; i >=0; i--) layers[i]=false;
        for (int layerN = 0; layerN < 32; layerN++) {
            double layerBase=Math.pow(0.5,layerN+1);
            if(num > layerBase){
                num-=layerBase;
                layers[layerN]=true;
            }else if(num==layerBase){
                layers[layerN]=true;
                //Return
                boolean startFlag=false;
                StringBuffer s=new StringBuffer();
                for (int i = 31; i >=0; i--) {
                    if(!startFlag && !layers[i])continue;
                    startFlag=true;
                    s.insert(0,layers[i]?"1":"0");
                }
                s.insert(0,"0.");
                return s.toString();
            }else{
                //num < layerBase
                layers[layerN]=false;
            }
        }
        return "ERROR";
    }
}
public class printBin {
    public static void main(String[] args) {
        System.out.println(Solution.printBin(0.625));
        System.out.println(Solution.printBin(0.6875));
        System.out.println("Run successful.");
    }
}
