package com.andisan86.e2etest.transformer;

public class DictionaryStatus {
    public enum Statuses {
        N("Negeri"),
        S("Swasta")
        ;

        private String status;

        Statuses(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

    public static String getStatusForId(String statusId) {
        return Statuses.valueOf(statusId).getStatus();
    }
}
