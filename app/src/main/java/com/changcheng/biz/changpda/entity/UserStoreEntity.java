package com.changcheng.biz.changpda.entity;

import java.util.List;

public class UserStoreEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"3","pages":"1","rows":[{"id":1320,"code":"ZD000001","name":"执照名1","sign":"7.27测试门店1","license":"执照编码1","province_id":null,"city_id":null,"district_id":null,"address":null,"lng":null,"lat":null,"manager":null,"phone":"18000000001","area_id":null,"salesman_id":null,"license_pic":null,"sign_pic":null,"head_pic":null,"type_id":null,"status":null,"create_id":null,"create_time":1532681246000,"update_id":null,"update_time":null,"start_id":null,"start_time":null,"stop_id":null,"stop_time":null,"stop_reason":null,"equipment_no":null,"original_code":null,"agreement_pic":null,"enabled":null,"enabled_time":null,"actual_address":null,"remarks":null,"final_status":null,"level_id":null,"channel_type_id":null,"base_channel_type":null,"sales_area_first":null,"sales_area_second":null,"sales_area_third":null,"sales_area_fourth":null,"agent_code":null,"agent_name":null,"sync_status":null,"sync_date":null,"version":null,"temporary_reason":null,"market_grouping":null,"join_time":null,"otis_code":null,"zone_id":null,"saleman_code":null,"zone_name":null,"province_name":null,"city_name":null,"district_name":null,"depart_code":null,"food_business_license_name":null,"food_business_license_address":null,"food_business_license_validate":null,"food_business_license_pic":null,"public_seal_pic":null,"origin":null,"dealer":null,"superarea":null,"subarea":null,"submit_man_code":null,"submitMan":null,"customerId":null,"create_by":null,"customerIds":null},{"id":1322,"code":"ZD000003","name":"执照名3","sign":"7.27测试门店3","license":"执照编码3","province_id":null,"city_id":null,"district_id":null,"address":null,"lng":null,"lat":null,"manager":null,"phone":"18000000003","area_id":null,"salesman_id":null,"license_pic":null,"sign_pic":null,"head_pic":null,"type_id":null,"status":null,"create_id":null,"create_time":1532681246000,"update_id":null,"update_time":null,"start_id":null,"start_time":null,"stop_id":null,"stop_time":null,"stop_reason":null,"equipment_no":null,"original_code":null,"agreement_pic":null,"enabled":null,"enabled_time":null,"actual_address":null,"remarks":null,"final_status":null,"level_id":null,"channel_type_id":null,"base_channel_type":null,"sales_area_first":null,"sales_area_second":null,"sales_area_third":null,"sales_area_fourth":null,"agent_code":null,"agent_name":null,"sync_status":null,"sync_date":null,"version":null,"temporary_reason":null,"market_grouping":null,"join_time":null,"otis_code":null,"zone_id":null,"saleman_code":null,"zone_name":null,"province_name":null,"city_name":null,"district_name":null,"depart_code":null,"food_business_license_name":null,"food_business_license_address":null,"food_business_license_validate":null,"food_business_license_pic":null,"public_seal_pic":null,"origin":null,"dealer":null,"superarea":null,"subarea":null,"submit_man_code":null,"submitMan":null,"customerId":null,"create_by":null,"customerIds":null},{"id":1388,"code":"MD00000053","name":null,"sign":"经销商测试终端","license":"34124321324","province_id":null,"city_id":null,"district_id":null,"address":null,"lng":null,"lat":null,"manager":null,"phone":"1321312312","area_id":null,"salesman_id":null,"license_pic":null,"sign_pic":null,"head_pic":null,"type_id":null,"status":null,"create_id":null,"create_time":1532915597000,"update_id":null,"update_time":null,"start_id":null,"start_time":null,"stop_id":null,"stop_time":null,"stop_reason":null,"equipment_no":null,"original_code":null,"agreement_pic":null,"enabled":null,"enabled_time":null,"actual_address":null,"remarks":null,"final_status":null,"level_id":null,"channel_type_id":null,"base_channel_type":null,"sales_area_first":null,"sales_area_second":null,"sales_area_third":null,"sales_area_fourth":null,"agent_code":null,"agent_name":null,"sync_status":null,"sync_date":null,"version":null,"temporary_reason":null,"market_grouping":null,"join_time":null,"otis_code":null,"zone_id":null,"saleman_code":null,"zone_name":null,"province_name":null,"city_name":null,"district_name":null,"depart_code":null,"food_business_license_name":null,"food_business_license_address":null,"food_business_license_validate":null,"food_business_license_pic":null,"public_seal_pic":null,"origin":null,"dealer":null,"superarea":null,"subarea":null,"submit_man_code":null,"submitMan":null,"customerId":null,"create_by":null,"customerIds":null}]}
     * ts : 1533801241429
     */

    private String code;
    private String msg;
    private DataBean data;
    private long ts;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public static class DataBean {
        /**
         * total : 3
         * pages : 1
         * rows : [{"id":1320,"code":"ZD000001","name":"执照名1","sign":"7.27测试门店1","license":"执照编码1","province_id":null,"city_id":null,"district_id":null,"address":null,"lng":null,"lat":null,"manager":null,"phone":"18000000001","area_id":null,"salesman_id":null,"license_pic":null,"sign_pic":null,"head_pic":null,"type_id":null,"status":null,"create_id":null,"create_time":1532681246000,"update_id":null,"update_time":null,"start_id":null,"start_time":null,"stop_id":null,"stop_time":null,"stop_reason":null,"equipment_no":null,"original_code":null,"agreement_pic":null,"enabled":null,"enabled_time":null,"actual_address":null,"remarks":null,"final_status":null,"level_id":null,"channel_type_id":null,"base_channel_type":null,"sales_area_first":null,"sales_area_second":null,"sales_area_third":null,"sales_area_fourth":null,"agent_code":null,"agent_name":null,"sync_status":null,"sync_date":null,"version":null,"temporary_reason":null,"market_grouping":null,"join_time":null,"otis_code":null,"zone_id":null,"saleman_code":null,"zone_name":null,"province_name":null,"city_name":null,"district_name":null,"depart_code":null,"food_business_license_name":null,"food_business_license_address":null,"food_business_license_validate":null,"food_business_license_pic":null,"public_seal_pic":null,"origin":null,"dealer":null,"superarea":null,"subarea":null,"submit_man_code":null,"submitMan":null,"customerId":null,"create_by":null,"customerIds":null},{"id":1322,"code":"ZD000003","name":"执照名3","sign":"7.27测试门店3","license":"执照编码3","province_id":null,"city_id":null,"district_id":null,"address":null,"lng":null,"lat":null,"manager":null,"phone":"18000000003","area_id":null,"salesman_id":null,"license_pic":null,"sign_pic":null,"head_pic":null,"type_id":null,"status":null,"create_id":null,"create_time":1532681246000,"update_id":null,"update_time":null,"start_id":null,"start_time":null,"stop_id":null,"stop_time":null,"stop_reason":null,"equipment_no":null,"original_code":null,"agreement_pic":null,"enabled":null,"enabled_time":null,"actual_address":null,"remarks":null,"final_status":null,"level_id":null,"channel_type_id":null,"base_channel_type":null,"sales_area_first":null,"sales_area_second":null,"sales_area_third":null,"sales_area_fourth":null,"agent_code":null,"agent_name":null,"sync_status":null,"sync_date":null,"version":null,"temporary_reason":null,"market_grouping":null,"join_time":null,"otis_code":null,"zone_id":null,"saleman_code":null,"zone_name":null,"province_name":null,"city_name":null,"district_name":null,"depart_code":null,"food_business_license_name":null,"food_business_license_address":null,"food_business_license_validate":null,"food_business_license_pic":null,"public_seal_pic":null,"origin":null,"dealer":null,"superarea":null,"subarea":null,"submit_man_code":null,"submitMan":null,"customerId":null,"create_by":null,"customerIds":null},{"id":1388,"code":"MD00000053","name":null,"sign":"经销商测试终端","license":"34124321324","province_id":null,"city_id":null,"district_id":null,"address":null,"lng":null,"lat":null,"manager":null,"phone":"1321312312","area_id":null,"salesman_id":null,"license_pic":null,"sign_pic":null,"head_pic":null,"type_id":null,"status":null,"create_id":null,"create_time":1532915597000,"update_id":null,"update_time":null,"start_id":null,"start_time":null,"stop_id":null,"stop_time":null,"stop_reason":null,"equipment_no":null,"original_code":null,"agreement_pic":null,"enabled":null,"enabled_time":null,"actual_address":null,"remarks":null,"final_status":null,"level_id":null,"channel_type_id":null,"base_channel_type":null,"sales_area_first":null,"sales_area_second":null,"sales_area_third":null,"sales_area_fourth":null,"agent_code":null,"agent_name":null,"sync_status":null,"sync_date":null,"version":null,"temporary_reason":null,"market_grouping":null,"join_time":null,"otis_code":null,"zone_id":null,"saleman_code":null,"zone_name":null,"province_name":null,"city_name":null,"district_name":null,"depart_code":null,"food_business_license_name":null,"food_business_license_address":null,"food_business_license_validate":null,"food_business_license_pic":null,"public_seal_pic":null,"origin":null,"dealer":null,"superarea":null,"subarea":null,"submit_man_code":null,"submitMan":null,"customerId":null,"create_by":null,"customerIds":null}]
         */

        private String total;
        private String pages;
        private List<RowsBean> rows;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 1320
             * code : ZD000001
             * name : 执照名1
             * sign : 7.27测试门店1
             * license : 执照编码1
             * province_id : null
             * city_id : null
             * district_id : null
             * address : null
             * lng : null
             * lat : null
             * manager : null
             * phone : 18000000001
             * area_id : null
             * salesman_id : null
             * license_pic : null
             * sign_pic : null
             * head_pic : null
             * type_id : null
             * status : null
             * create_id : null
             * create_time : 1532681246000
             * update_id : null
             * update_time : null
             * start_id : null
             * start_time : null
             * stop_id : null
             * stop_time : null
             * stop_reason : null
             * equipment_no : null
             * original_code : null
             * agreement_pic : null
             * enabled : null
             * enabled_time : null
             * actual_address : null
             * remarks : null
             * final_status : null
             * level_id : null
             * channel_type_id : null
             * base_channel_type : null
             * sales_area_first : null
             * sales_area_second : null
             * sales_area_third : null
             * sales_area_fourth : null
             * agent_code : null
             * agent_name : null
             * sync_status : null
             * sync_date : null
             * version : null
             * temporary_reason : null
             * market_grouping : null
             * join_time : null
             * otis_code : null
             * zone_id : null
             * saleman_code : null
             * zone_name : null
             * province_name : null
             * city_name : null
             * district_name : null
             * depart_code : null
             * food_business_license_name : null
             * food_business_license_address : null
             * food_business_license_validate : null
             * food_business_license_pic : null
             * public_seal_pic : null
             * origin : null
             * dealer : null
             * superarea : null
             * subarea : null
             * submit_man_code : null
             * submitMan : null
             * customerId : null
             * create_by : null
             * customerIds : null
             */

            private int id;
            private String code;
            private String name;
            private String sign;
            private String license;
            private Object province_id;
            private Object city_id;
            private Object district_id;
            private Object address;
            private Object lng;
            private Object lat;
            private Object manager;
            private String phone;
            private Object area_id;
            private Object salesman_id;
            private Object license_pic;
            private Object sign_pic;
            private Object head_pic;
            private Object type_id;
            private Object status;
            private Object create_id;
            private long create_time;
            private Object update_id;
            private Object update_time;
            private Object start_id;
            private Object start_time;
            private Object stop_id;
            private Object stop_time;
            private Object stop_reason;
            private Object equipment_no;
            private Object original_code;
            private Object agreement_pic;
            private Object enabled;
            private Object enabled_time;
            private Object actual_address;
            private Object remarks;
            private Object final_status;
            private Object level_id;
            private Object channel_type_id;
            private Object base_channel_type;
            private Object sales_area_first;
            private Object sales_area_second;
            private Object sales_area_third;
            private Object sales_area_fourth;
            private Object agent_code;
            private Object agent_name;
            private Object sync_status;
            private Object sync_date;
            private Object version;
            private Object temporary_reason;
            private Object market_grouping;
            private Object join_time;
            private Object otis_code;
            private Object zone_id;
            private Object saleman_code;
            private Object zone_name;
            private Object province_name;
            private Object city_name;
            private Object district_name;
            private Object depart_code;
            private Object food_business_license_name;
            private Object food_business_license_address;
            private Object food_business_license_validate;
            private Object food_business_license_pic;
            private Object public_seal_pic;
            private Object origin;
            private Object dealer;
            private Object superarea;
            private Object subarea;
            private Object submit_man_code;
            private Object submitMan;
            private Object customerId;
            private Object create_by;
            private Object customerIds;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getLicense() {
                return license;
            }

            public void setLicense(String license) {
                this.license = license;
            }

            public Object getProvince_id() {
                return province_id;
            }

            public void setProvince_id(Object province_id) {
                this.province_id = province_id;
            }

            public Object getCity_id() {
                return city_id;
            }

            public void setCity_id(Object city_id) {
                this.city_id = city_id;
            }

            public Object getDistrict_id() {
                return district_id;
            }

            public void setDistrict_id(Object district_id) {
                this.district_id = district_id;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getLng() {
                return lng;
            }

            public void setLng(Object lng) {
                this.lng = lng;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
                this.lat = lat;
            }

            public Object getManager() {
                return manager;
            }

            public void setManager(Object manager) {
                this.manager = manager;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getArea_id() {
                return area_id;
            }

            public void setArea_id(Object area_id) {
                this.area_id = area_id;
            }

            public Object getSalesman_id() {
                return salesman_id;
            }

            public void setSalesman_id(Object salesman_id) {
                this.salesman_id = salesman_id;
            }

            public Object getLicense_pic() {
                return license_pic;
            }

            public void setLicense_pic(Object license_pic) {
                this.license_pic = license_pic;
            }

            public Object getSign_pic() {
                return sign_pic;
            }

            public void setSign_pic(Object sign_pic) {
                this.sign_pic = sign_pic;
            }

            public Object getHead_pic() {
                return head_pic;
            }

            public void setHead_pic(Object head_pic) {
                this.head_pic = head_pic;
            }

            public Object getType_id() {
                return type_id;
            }

            public void setType_id(Object type_id) {
                this.type_id = type_id;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getCreate_id() {
                return create_id;
            }

            public void setCreate_id(Object create_id) {
                this.create_id = create_id;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public Object getUpdate_id() {
                return update_id;
            }

            public void setUpdate_id(Object update_id) {
                this.update_id = update_id;
            }

            public Object getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(Object update_time) {
                this.update_time = update_time;
            }

            public Object getStart_id() {
                return start_id;
            }

            public void setStart_id(Object start_id) {
                this.start_id = start_id;
            }

            public Object getStart_time() {
                return start_time;
            }

            public void setStart_time(Object start_time) {
                this.start_time = start_time;
            }

            public Object getStop_id() {
                return stop_id;
            }

            public void setStop_id(Object stop_id) {
                this.stop_id = stop_id;
            }

            public Object getStop_time() {
                return stop_time;
            }

            public void setStop_time(Object stop_time) {
                this.stop_time = stop_time;
            }

            public Object getStop_reason() {
                return stop_reason;
            }

            public void setStop_reason(Object stop_reason) {
                this.stop_reason = stop_reason;
            }

            public Object getEquipment_no() {
                return equipment_no;
            }

            public void setEquipment_no(Object equipment_no) {
                this.equipment_no = equipment_no;
            }

            public Object getOriginal_code() {
                return original_code;
            }

            public void setOriginal_code(Object original_code) {
                this.original_code = original_code;
            }

            public Object getAgreement_pic() {
                return agreement_pic;
            }

            public void setAgreement_pic(Object agreement_pic) {
                this.agreement_pic = agreement_pic;
            }

            public Object getEnabled() {
                return enabled;
            }

            public void setEnabled(Object enabled) {
                this.enabled = enabled;
            }

            public Object getEnabled_time() {
                return enabled_time;
            }

            public void setEnabled_time(Object enabled_time) {
                this.enabled_time = enabled_time;
            }

            public Object getActual_address() {
                return actual_address;
            }

            public void setActual_address(Object actual_address) {
                this.actual_address = actual_address;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public Object getFinal_status() {
                return final_status;
            }

            public void setFinal_status(Object final_status) {
                this.final_status = final_status;
            }

            public Object getLevel_id() {
                return level_id;
            }

            public void setLevel_id(Object level_id) {
                this.level_id = level_id;
            }

            public Object getChannel_type_id() {
                return channel_type_id;
            }

            public void setChannel_type_id(Object channel_type_id) {
                this.channel_type_id = channel_type_id;
            }

            public Object getBase_channel_type() {
                return base_channel_type;
            }

            public void setBase_channel_type(Object base_channel_type) {
                this.base_channel_type = base_channel_type;
            }

            public Object getSales_area_first() {
                return sales_area_first;
            }

            public void setSales_area_first(Object sales_area_first) {
                this.sales_area_first = sales_area_first;
            }

            public Object getSales_area_second() {
                return sales_area_second;
            }

            public void setSales_area_second(Object sales_area_second) {
                this.sales_area_second = sales_area_second;
            }

            public Object getSales_area_third() {
                return sales_area_third;
            }

            public void setSales_area_third(Object sales_area_third) {
                this.sales_area_third = sales_area_third;
            }

            public Object getSales_area_fourth() {
                return sales_area_fourth;
            }

            public void setSales_area_fourth(Object sales_area_fourth) {
                this.sales_area_fourth = sales_area_fourth;
            }

            public Object getAgent_code() {
                return agent_code;
            }

            public void setAgent_code(Object agent_code) {
                this.agent_code = agent_code;
            }

            public Object getAgent_name() {
                return agent_name;
            }

            public void setAgent_name(Object agent_name) {
                this.agent_name = agent_name;
            }

            public Object getSync_status() {
                return sync_status;
            }

            public void setSync_status(Object sync_status) {
                this.sync_status = sync_status;
            }

            public Object getSync_date() {
                return sync_date;
            }

            public void setSync_date(Object sync_date) {
                this.sync_date = sync_date;
            }

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }

            public Object getTemporary_reason() {
                return temporary_reason;
            }

            public void setTemporary_reason(Object temporary_reason) {
                this.temporary_reason = temporary_reason;
            }

            public Object getMarket_grouping() {
                return market_grouping;
            }

            public void setMarket_grouping(Object market_grouping) {
                this.market_grouping = market_grouping;
            }

            public Object getJoin_time() {
                return join_time;
            }

            public void setJoin_time(Object join_time) {
                this.join_time = join_time;
            }

            public Object getOtis_code() {
                return otis_code;
            }

            public void setOtis_code(Object otis_code) {
                this.otis_code = otis_code;
            }

            public Object getZone_id() {
                return zone_id;
            }

            public void setZone_id(Object zone_id) {
                this.zone_id = zone_id;
            }

            public Object getSaleman_code() {
                return saleman_code;
            }

            public void setSaleman_code(Object saleman_code) {
                this.saleman_code = saleman_code;
            }

            public Object getZone_name() {
                return zone_name;
            }

            public void setZone_name(Object zone_name) {
                this.zone_name = zone_name;
            }

            public Object getProvince_name() {
                return province_name;
            }

            public void setProvince_name(Object province_name) {
                this.province_name = province_name;
            }

            public Object getCity_name() {
                return city_name;
            }

            public void setCity_name(Object city_name) {
                this.city_name = city_name;
            }

            public Object getDistrict_name() {
                return district_name;
            }

            public void setDistrict_name(Object district_name) {
                this.district_name = district_name;
            }

            public Object getDepart_code() {
                return depart_code;
            }

            public void setDepart_code(Object depart_code) {
                this.depart_code = depart_code;
            }

            public Object getFood_business_license_name() {
                return food_business_license_name;
            }

            public void setFood_business_license_name(Object food_business_license_name) {
                this.food_business_license_name = food_business_license_name;
            }

            public Object getFood_business_license_address() {
                return food_business_license_address;
            }

            public void setFood_business_license_address(Object food_business_license_address) {
                this.food_business_license_address = food_business_license_address;
            }

            public Object getFood_business_license_validate() {
                return food_business_license_validate;
            }

            public void setFood_business_license_validate(Object food_business_license_validate) {
                this.food_business_license_validate = food_business_license_validate;
            }

            public Object getFood_business_license_pic() {
                return food_business_license_pic;
            }

            public void setFood_business_license_pic(Object food_business_license_pic) {
                this.food_business_license_pic = food_business_license_pic;
            }

            public Object getPublic_seal_pic() {
                return public_seal_pic;
            }

            public void setPublic_seal_pic(Object public_seal_pic) {
                this.public_seal_pic = public_seal_pic;
            }

            public Object getOrigin() {
                return origin;
            }

            public void setOrigin(Object origin) {
                this.origin = origin;
            }

            public Object getDealer() {
                return dealer;
            }

            public void setDealer(Object dealer) {
                this.dealer = dealer;
            }

            public Object getSuperarea() {
                return superarea;
            }

            public void setSuperarea(Object superarea) {
                this.superarea = superarea;
            }

            public Object getSubarea() {
                return subarea;
            }

            public void setSubarea(Object subarea) {
                this.subarea = subarea;
            }

            public Object getSubmit_man_code() {
                return submit_man_code;
            }

            public void setSubmit_man_code(Object submit_man_code) {
                this.submit_man_code = submit_man_code;
            }

            public Object getSubmitMan() {
                return submitMan;
            }

            public void setSubmitMan(Object submitMan) {
                this.submitMan = submitMan;
            }

            public Object getCustomerId() {
                return customerId;
            }

            public void setCustomerId(Object customerId) {
                this.customerId = customerId;
            }

            public Object getCreate_by() {
                return create_by;
            }

            public void setCreate_by(Object create_by) {
                this.create_by = create_by;
            }

            public Object getCustomerIds() {
                return customerIds;
            }

            public void setCustomerIds(Object customerIds) {
                this.customerIds = customerIds;
            }
        }
    }
}
