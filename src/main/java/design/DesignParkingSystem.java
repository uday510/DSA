package design;

// https://leetcode.com/problems/design-parking-system/?envType=study-plan-v2&envId=programming-skills

class ParkingSystem {

    int[] space;

    public ParkingSystem(int big, int medium, int small) {
        space = new int[] {big, medium, small};
    }

    public boolean addCar(int carType) {
        if (space[carType - 1] <= 0)
            return false;

        space[carType - 1]--;
        return true;
    }
}