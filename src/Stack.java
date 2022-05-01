import java.util.ArrayList;

/**
 * @Author Yunrui Huang
 * the stack class for this PDA
 */
public class Stack {
    private ArrayList<String> stack;

    /**
     * the constructor of this class
     */
    public Stack(){
        this.stack = new ArrayList<>();
    }

    /**
     * push a string in this stack
     * @param in
     * the string use to push in
     */
    public void push(String in){
        this.stack.add(in);
    }

    /**
     * pop a string out of stack
     * @return
     * the string at the top of stack, return null if nothing
     */
    public String pop(){
        if(this.stack.isEmpty()){
            return null;
        }else{
            String out = this.stack.get(this.stack.size()-1);
            this.stack.remove(this.stack.size()-1);
            return out;
        }
    }

    /**
     * get all the stack
     * @return
     * the arraylist of this stack
     */
    public ArrayList<String> getStack() {
        return stack;
    }

    /**
     * override the toString method to print the stack
     * @return
     * the string to print
     */
    public String toString(){
        String out = "";
        for (int i = 0; i < this.stack.size(); i++) {
            out = "\n--\n" + this.stack.get(i) + out;
        }
        return out;
    }

}
