package com.example.makinde.aybook;

public class ItemObject {

    private String name;
    private String email;
    private String phone;

    public ItemObject(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean get(boolean valueIfKeyNotFound) {
        return false;
        //todo get from db query
    }

    /**
     * Removes the mapping from the specified key, if there was any.
     */
    public void delete(int key) {

        //todo delete the commented section below and put in a db query for delete
//        int i = ContainerHelpers.binarySearch(mKeys, mSize, key);
//
//        if (i >= 0) {
//            System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
//            System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
//            mSize--;
//        }
    }

    /**
     * Removes the mapping at the specified index.
     * <p>
     * For indices outside of the range {@code 0...size()-1}, the behavior is undefined.
     */
    public void removeAt(int index) {

        //todo delete the commented section below and put in a db query for removeAt
    }

    /**
     * Adds a mapping from the specified key to the specified value,
     * replacing the previous mapping from the specified key if there
     * was one.
     */
    public void put(int key, boolean value) {

        //todo delete the commented section below and put in a db query for put
//        int i = ContainerHelpers.binarySearch(mKeys, mSize, key);
//
//        if (i >= 0) {
//            mValues[i] = value;
//        } else {
//            i = ~i;
//
//            mKeys = GrowingArrayUtils.insert(mKeys, mSize, i, key);
//            mValues = GrowingArrayUtils.insert(mValues, mSize, i, value);
//            mSize++;
//        }
    }

}