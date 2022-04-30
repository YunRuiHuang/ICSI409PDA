import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;

    public Stack(){
        this.stack = new ArrayList<>();
    }

    public void push(String in){
        this.stack.add(in);
    }

    public String pop(){
        if(this.stack.isEmpty()){
            return null;
        }else{
            String out = this.stack.get(this.stack.size()-1);
            this.stack.remove(this.stack.size()-1);
            return out;
        }
    }

    public ArrayList<String> getStack() {
        return stack;
    }

    public String toString(){
        String out = "";
        for (int i = 0; i < this.stack.size(); i++) {
            out = "\n--\n" + this.stack.get(i) + out;
        }
        return out;
    }

}
