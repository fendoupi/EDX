package entity.net;

import java.util.List;

/**
 * Created by yuan on 2016/5/4.
 */
public class UserAllCourseInfo {

    /**
     * created : 2016-03-07T02:44:59Z
     * mode : audit
     * is_active : true
     * course_details : {"course_id":"course-v1:edX+DemoX+Demo_Course","enrollment_start":null,"enrollment_end":null,"course_start":"2013-02-05T05:00:00Z","course_end":null,"invite_only":false,"course_modes":[{"slug":"audit","name":"旁听","min_price":0,"suggested_prices":"","currency":"usd","expiration_datetime":null,"description":null,"sku":null}]}
     * user : wangyu
     */

    private String created;
    private String mode;
    private boolean is_active;
    /**
     * course_id : course-v1:edX+DemoX+Demo_Course
     * enrollment_start : null
     * enrollment_end : null
     * course_start : 2013-02-05T05:00:00Z
     * course_end : null
     * invite_only : false
     * course_modes : [{"slug":"audit","name":"旁听","min_price":0,"suggested_prices":"","currency":"usd","expiration_datetime":null,"description":null,"sku":null}]
     */

    private CourseDetailsEntity course_details;
    private String user;

    public void setCreated(String created) {
        this.created = created;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public void setCourse_details(CourseDetailsEntity course_details) {
        this.course_details = course_details;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreated() {
        return created;
    }

    public String getMode() {
        return mode;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public CourseDetailsEntity getCourse_details() {
        return course_details;
    }

    public String getUser() {
        return user;
    }

    public static class CourseDetailsEntity {
        private String course_id;
        private Object enrollment_start;
        private Object enrollment_end;
        private String course_start;
        private Object course_end;
        private boolean invite_only;
        /**
         * slug : audit
         * name : 旁听
         * min_price : 0
         * suggested_prices :
         * currency : usd
         * expiration_datetime : null
         * description : null
         * sku : null
         */

        private List<CourseModesEntity> course_modes;

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public void setEnrollment_start(Object enrollment_start) {
            this.enrollment_start = enrollment_start;
        }

        public void setEnrollment_end(Object enrollment_end) {
            this.enrollment_end = enrollment_end;
        }

        public void setCourse_start(String course_start) {
            this.course_start = course_start;
        }

        public void setCourse_end(Object course_end) {
            this.course_end = course_end;
        }

        public void setInvite_only(boolean invite_only) {
            this.invite_only = invite_only;
        }

        public void setCourse_modes(List<CourseModesEntity> course_modes) {
            this.course_modes = course_modes;
        }

        public String getCourse_id() {
            return course_id;
        }

        public Object getEnrollment_start() {
            return enrollment_start;
        }

        public Object getEnrollment_end() {
            return enrollment_end;
        }

        public String getCourse_start() {
            return course_start;
        }

        public Object getCourse_end() {
            return course_end;
        }

        public boolean isInvite_only() {
            return invite_only;
        }

        public List<CourseModesEntity> getCourse_modes() {
            return course_modes;
        }

        public static class CourseModesEntity {
            private String slug;
            private String name;
            private int min_price;
            private String suggested_prices;
            private String currency;
            private Object expiration_datetime;
            private Object description;
            private Object sku;

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setMin_price(int min_price) {
                this.min_price = min_price;
            }

            public void setSuggested_prices(String suggested_prices) {
                this.suggested_prices = suggested_prices;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public void setExpiration_datetime(Object expiration_datetime) {
                this.expiration_datetime = expiration_datetime;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public void setSku(Object sku) {
                this.sku = sku;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }

            public int getMin_price() {
                return min_price;
            }

            public String getSuggested_prices() {
                return suggested_prices;
            }

            public String getCurrency() {
                return currency;
            }

            public Object getExpiration_datetime() {
                return expiration_datetime;
            }

            public Object getDescription() {
                return description;
            }

            public Object getSku() {
                return sku;
            }
        }
    }
}
