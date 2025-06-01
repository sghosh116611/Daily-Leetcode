class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Split = version1.split("\\.");
        String[] version2Split = version2.split("\\.");

        // // Check for major version change
        String majorVersion1 = version1Split[0];
        String majorVersion2 = version2Split[0];

        if(Integer.parseInt(majorVersion1) < Integer.parseInt(majorVersion2)){
            return -1;
        }else if(Integer.parseInt(majorVersion1) > Integer.parseInt(majorVersion2)){
            return 1;
        }else{
            // Check for minor version changes
            int i = 1;
            while(i < version1Split.length || i < version2Split.length){
                if(i < version1Split.length && i < version2Split.length){
                    if(Integer.parseInt(version1Split[i]) < Integer.parseInt(version2Split[i])){
                        return -1;
                    }else if(Integer.parseInt(version1Split[i]) > Integer.parseInt(version2Split[i])){
                        return 1;
                    }
                }else if(i < version1Split.length){
                    if(Integer.parseInt(version1Split[i]) != 0){
                        return 1;
                    }
                }else {
                    if(Integer.parseInt(version2Split[i]) != 0){
                        return -1;
                    }
                }
                i++;
            }

            return 0;
        }
    }
}