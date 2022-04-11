public class Person {
        public String name;
        public int xuhao;
        public int fenshu;
        public String time;
        public String adress;
        public String dingdanzhuangtai;
        public int bianhao;

    public int getBianhao() {
        return bianhao;
    }

    public void setBianhao(int bianhao) {
        this.bianhao = bianhao;
    }

    public String getDingdanzhuangtai() {
        return dingdanzhuangtai;
    }

    public void setDingdanzhuangtai(String dingdanzhuangtai) {
        this.dingdanzhuangtai = dingdanzhuangtai;
    }

    public String cainame(){
        if(this.xuhao==1){
            return "红烧带鱼";
        }else if(this.xuhao==2){
            return "鱼香肉丝";
        }else if(this.xuhao==3){
            return "时令蔬菜";
        }
        return null;
    }
    public double caifei(){
        if(this.xuhao==1){
            return this.fenshu*38.00;
        }else if(this.xuhao==2){
            return this.fenshu*20.0;
        }else if(this.xuhao==3){
            return this.fenshu*10.0;
        }
        return 0;
    }
    public Person() {
    }

    public Person(String name, int xuhao, int fenshu, String time, String adress) {
        this.name = name;
        this.xuhao = xuhao;
        this.fenshu = fenshu;
        this.time = time;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public int getFenshu() {
        return fenshu;
    }

    public void setFenshu(int fenshu) {
        this.fenshu = fenshu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
