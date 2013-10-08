package edu.unisa.dspace.entities.response.bitstreams;

public enum BitStreamType {

	EMPTY("EMPTY"), ORIGINAL("ORIGINAL"), THUMBNAIL("THUMBNAIL"), PREVIEW("PREVIEW"), LICENSE("LICENSE"), SWORD("SWORD");


    private BitStreamType(final String text) {
        this.text = text;
    }

    private final String text;


    @Override
    public String toString() {
        return text;
    }
    
    public static boolean contains(String test) {

        for (BitStreamType c : BitStreamType.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
	
}
