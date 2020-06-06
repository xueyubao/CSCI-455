public class testRack {

    public static void main(String[] args) {
        Rack rack = new Rack("caabb");
        System.out.println(rack.getLetterAndNum());
        System.out.println(rack.subSets());
        System.out.println(rack.subSets().size());
    }

}
