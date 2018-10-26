public class Selection {
    public String zipCode1(int zip) {
        if (zip==94040) return "Mountain View";
        else if (zip==94115) return "San Francisco";
        else if (zip==95051) return "Santa Clara";
        else return "Not Valid";
    }
    public String zipCode2(int zip) {
        String city;
        switch (zip) {
            case 95129: return city = "San Jose";
            case 94607: return city = "Oakland";
            case 95035: return city = "Milpitas";
            default: return city = "Not Valid";
        }
    }
    public String zipCode3(int zip) {
        if (zip==94301) return "Palo Alto";
        if (zip==94086) return "Sunnyvale";
        if (zip==95037) return "Morgan Hill";
        return "Not Valid";
    }
    
}