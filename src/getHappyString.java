import java.util.Vector;

class Solution10 {
    public static String getHappyString(int n, int k) {
        //!solved n=1 issue (my poor work on small examples)
        if (n == 1) {
            return (k == 3) ? "c" : (k == 2 ? "b" : (k == 1 ? "a" : ""));
        }
        int layer = n, layerSize = 2;
        // layer means the l-th level
        int[] layers = new int[n + 1];
        layers[n] = 1;
        //! fix array outofbound error because program asks for non-existent layerSize
        while (layer > 0 && k > layerSize) {
            //size of layer n-1
            layers[layer - 1] = layerSize;
            layer--;
            layerSize *= (layer == 1) ? 3 : 2;
        }
        //! fix false halt condition
        if (layer == 0) return "";
        //! this statement still useful! no delete!
        layers[layer - 1] = layerSize;
        int[] sequence = new int[n - layer + 1];
        int initial = layer;
        if (layer == 1) {
            // solve layer-1 issue
            //! fixed no-jump-out issue by adding = in 1st condition
            if (layers[0] >= k && k > 2 * layers[1]) {
                sequence[0] = 3;
                k -= 2 * layers[1];
            } else if (2 * layers[1] >= k && k > layers[1]) {
                sequence[0] = 2;
                k -= layers[1];
            }//! here do not need another else, cause it's impossible
            layer++;
        }
        while (layer <= n) {
            if (layers[layer - 1] >= k && k > layers[layer - 1 + 1]) {
                // this level matters
                sequence[layer - initial] = 2;
                k -= layers[layer - 1 + 1];
            } else if (k <= layers[layer - 1 + 1]) {
                // depends on next level
                sequence[layer - initial] = 1;
            }
            layer++;
        }
        // translate sequence into abc
        StringBuilder ans = new StringBuilder();
        //! from here, I move the layer==0 part out from print function
        // and refactored some parts
        char lastChr = 'c';
        boolean skip1stFlag = false;
        if (n > sequence.length) {
            // non-sense default value
            for (int i = 0; i < n - sequence.length; i++) {
                Vector<Character> chr = new Vector<>();
                chr.addElement('a');
                chr.addElement('b');
                chr.addElement('c');
                chr.removeElement(lastChr);
                lastChr = chr.elementAt(0);
                ans.append(lastChr);
            }
        } else {
            lastChr = (sequence[0] == 3) ? 'c' : (sequence[0] == 2 ? 'b' : 'a');
            ans.append(lastChr);
            skip1stFlag = true;
        }

        for (int each : sequence) {
            if (skip1stFlag) {
                skip1stFlag = false;
                continue;
            }
            Vector<Character> chr = new Vector<>();
            chr.addElement('a');
            chr.addElement('b');
            chr.addElement('c');
            chr.removeElement(lastChr);
            lastChr = each == 2 ? chr.elementAt(1) : chr.elementAt(0);
            ans.append(lastChr);
        }
        return ans.toString();
    }

}

public class getHappyString {
    public static void main(String[] args) {
        //!more failing tests
        System.out.println(Solution10.getHappyString(3, 12));
        System.out.println(Solution10.getHappyString(2, 4));
        System.out.println(Solution10.getHappyString(3, 9));
        System.out.println(Solution10.getHappyString(10, 100));
        System.out.print("Run successful.");
    }
}
