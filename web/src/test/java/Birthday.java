/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/5/17 上午10:33 $
 */
public class Birthday {
    private String birthday;

    public Birthday(String birthday) {
        super();
        this.birthday = birthday;
    }
    //setter、getter
    public Birthday() {}

    @Override
    public String toString() {
        return this.birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}