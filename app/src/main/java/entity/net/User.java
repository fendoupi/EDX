package entity.net;

import java.util.List;

/**
 * Created by yuan on 2016/4/21.
 */
public class User {

    /**
     * username : wangyu
     * bio : asdasdsaas
     * requires_parental_consent : false
     * name : kid_kz
     * country : null
     * is_active : true
     * profile_image : {"image_url_full":"http://edx.dev.cloudkz.cn:81/static/images/profiles/default_500.de2c6854f1eb.png","image_url_large":"http://edx.dev.cloudkz.cn:81/static/images/profiles/default_120.33ad4f755071.png","image_url_medium":"http://edx.dev.cloudkz.cn:81/static/images/profiles/default_50.5fb006f96a15.png","image_url_small":"http://edx.dev.cloudkz.cn:81/static/images/profiles/default_30.ae6a9ca9b390.png","has_image":false}
     * year_of_birth : 1900
     * level_of_education : el
     * goals : 我是开发者，我喜欢
     * language_proficiencies : []
     * gender : o
     * account_privacy : all_users
     * mailing_address : 重庆市北碚区西南大学
     * email : 1837960253@qq.com
     * date_joined : 2016-03-07T02:33:33Z
     */

    private String username;
    private String bio;
    private boolean requires_parental_consent;
    private String name;
    private Object country;
    private boolean is_active;
    /**
     * image_url_full : http://edx.dev.cloudkz.cn:81/static/images/profiles/default_500.de2c6854f1eb.png
     * image_url_large : http://edx.dev.cloudkz.cn:81/static/images/profiles/default_120.33ad4f755071.png
     * image_url_medium : http://edx.dev.cloudkz.cn:81/static/images/profiles/default_50.5fb006f96a15.png
     * image_url_small : http://edx.dev.cloudkz.cn:81/static/images/profiles/default_30.ae6a9ca9b390.png
     * has_image : false
     */

    private ProfileImageEntity profile_image;
    private int year_of_birth;
    private String level_of_education;
    private String goals;
    private String gender;
    private String account_privacy;
    private String mailing_address;
    private String email;
    private String date_joined;
    private List<?> language_proficiencies;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setRequires_parental_consent(boolean requires_parental_consent) {
        this.requires_parental_consent = requires_parental_consent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public void setProfile_image(ProfileImageEntity profile_image) {
        this.profile_image = profile_image;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public void setLevel_of_education(String level_of_education) {
        this.level_of_education = level_of_education;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAccount_privacy(String account_privacy) {
        this.account_privacy = account_privacy;
    }

    public void setMailing_address(String mailing_address) {
        this.mailing_address = mailing_address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public void setLanguage_proficiencies(List<?> language_proficiencies) {
        this.language_proficiencies = language_proficiencies;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public boolean isRequires_parental_consent() {
        return requires_parental_consent;
    }

    public String getName() {
        return name;
    }

    public Object getCountry() {
        return country;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public ProfileImageEntity getProfile_image() {
        return profile_image;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public String getLevel_of_education() {
        return level_of_education;
    }

    public String getGoals() {
        return goals;
    }

    public String getGender() {
        return gender;
    }

    public String getAccount_privacy() {
        return account_privacy;
    }

    public String getMailing_address() {
        return mailing_address;
    }

    public String getEmail() {
        return email;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public List<?> getLanguage_proficiencies() {
        return language_proficiencies;
    }

    public static class ProfileImageEntity {
        private String image_url_full;
        private String image_url_large;
        private String image_url_medium;
        private String image_url_small;
        private boolean has_image;

        public void setImage_url_full(String image_url_full) {
            this.image_url_full = image_url_full;
        }

        public void setImage_url_large(String image_url_large) {
            this.image_url_large = image_url_large;
        }

        public void setImage_url_medium(String image_url_medium) {
            this.image_url_medium = image_url_medium;
        }

        public void setImage_url_small(String image_url_small) {
            this.image_url_small = image_url_small;
        }

        public void setHas_image(boolean has_image) {
            this.has_image = has_image;
        }

        public String getImage_url_full() {
            return image_url_full;
        }

        public String getImage_url_large() {
            return image_url_large;
        }

        public String getImage_url_medium() {
            return image_url_medium;
        }

        public String getImage_url_small() {
            return image_url_small;
        }

        public boolean isHas_image() {
            return has_image;
        }
    }
}
