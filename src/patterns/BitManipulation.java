public class BitManipulation {

    boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    int setBit(int num, int i) {
        return num | (1 << i);
    }

    int clearBit(int num, int i) {
        int mask = ~(1 << i);

        return num & mask;
    }

    int updateBit(int num, int i, boolean updateToOne) {
        int value = updateToOne ? 1 : 0;
        int mask = ~(1 << i);

        return (num & mask) | (value << i);
    }
}
