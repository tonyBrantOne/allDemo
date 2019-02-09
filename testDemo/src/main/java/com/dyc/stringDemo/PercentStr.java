package com.dyc.stringDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/24 11:20
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/24 11:20
 * @Description:
 */
public class PercentStr {
 //   private static final String url = "dubbo%3A%2F%2F10.0.1.15%3A29999%2Forg.soul.iservice.taskschedule.ITaskScheduleService%3Fanyhost%3Dtrue%26application%3Dboss-schedule-service%26default.delay%3D0%26default.loadbalance%3Drandom%26default.service.filter%3D-exception%2C-timeout%26default.timeout%3D10000%26default.version%3DA-1_test-1.0.2%26delay%3D0%26dispatcher%3Dall%26dubbo%3D2.5.3%26interface%3Dorg.soul.iservice.taskschedule.ITaskScheduleService%26logger%3Dslf4j%26methods%3DallSearchProperties%2CinSearch%2CpagingReturnProperties%2CinSearchPropertyById%2CandSearchProperty%2CallSearchProperty%2ConeSearch%2ConeSearchProperties%2CinSearchProperties%2CinSearchById%2CinsertOnly%2CpauseAllEnableTask%2CpagingSearch%2CresumeTask%2CinSearchProperty%2CinSearchPropertiesById%2CbatchUpdateOnlyWhen%2ConeSearchProperty%2CorSearchProperties%2CandSearch%2CinsertExclude%2Cquery%2Ccount%2CrunOnceTask%2CupdateTask%2CbatchInsertOnly%2CbatchUpdateExcludePropertiesWhen%2CcreateTask%2CupdateExcludePropertiesWhen%2CbatchUpdateOnly%2CcreateTaskAndLoad%2CbatchUpdateExcludeProperties%2CbatchDeleteCriteria%2CgetJobNextFireTime%2CallSearch%2CbatchInsert%2CbatchUpdate%2CdeleteAllQuartzTask%2Cupdate%2Cinsert%2Csum%2CsearchProperty%2Cdelete%2CupdateOnly%2CbatchUpdateWhen%2CbatchDelete%2CsearchProperties%2CupdateExcludeProperties%2Csearch%2CresumeAllEnableTask%2Cavg%2Cmin%2CdeleteExpireTask%2Cget%2CandSearchProperties%2CbatchInsertExclude%2CorSearch%2CupdateOnlyWhen%2CpagingReturnProperty%2Cmax%2CinitScheduleTask%2CorSearchProperty%2CpauseTask%2CdeleteTask%2CupdateWhen%26payload%3D83886080%26pid%3D1%26revision%3D1.0.7.4-SNAPSHOT%26side%3Dprovider%26threadpool%3Dcached%26threads%3D300%26timestamp%3D1545619019547";
    private static final String url ="dubbo%3A%2F%2F10.0.1.15%3A29999%2Forg.soul.iservice.taskschedule.ITaskScheduleService%3Fanyhost%3Dtrue%26application%3Dboss-schedule-service%26default.delay%3D0%26default.loadbalance%3Drandom%26default.service.filter%3D-exception%2C-timeout%26default.timeout%3D10000%26default.version%3DA-1_release-12-new%26delay%3D0%26dispatcher%3Dall%26dubbo%3D2.5.3%26interface%3Dorg.soul.iservice.taskschedule.ITaskScheduleService%26logger%3Dslf4j%26methods%3DallSearchProperties%2CinSearch%2CpagingReturnProperties%2CinSearchPropertyById%2CandSearchProperty%2CallSearchProperty%2ConeSearch%2ConeSearchProperties%2CinSearchProperties%2CinSearchById%2CinsertOnly%2CpauseAllEnableTask%2CpagingSearch%2CresumeTask%2CinSearchProperty%2CinSearchPropertiesById%2CbatchUpdateOnlyWhen%2ConeSearchProperty%2CorSearchProperties%2CandSearch%2CinsertExclude%2Cquery%2Ccount%2CrunOnceTask%2CupdateTask%2CbatchInsertOnly%2CbatchUpdateExcludePropertiesWhen%2CcreateTask%2CupdateExcludePropertiesWhen%2CbatchUpdateOnly%2CcreateTaskAndLoad%2CbatchUpdateExcludeProperties%2CbatchDeleteCriteria%2CgetJobNextFireTime%2CallSearch%2CbatchInsert%2CbatchUpdate%2CdeleteAllQuartzTask%2Cupdate%2Cinsert%2Csum%2CsearchProperty%2Cdelete%2CupdateOnly%2CbatchUpdateWhen%2CbatchDelete%2CsearchProperties%2CupdateExcludeProperties%2Csearch%2CresumeAllEnableTask%2Cavg%2Cmin%2CdeleteExpireTask%2Cget%2CandSearchProperties%2CbatchInsertExclude%2CorSearch%2CupdateOnlyWhen%2CpagingReturnProperty%2Cmax%2CinitScheduleTask%2CorSearchProperty%2CpauseTask%2CdeleteTask%2CupdateWhen%26payload%3D83886080%26pid%3D1%26revision%3D1.0.7.4-SNAPSHOT%26side%3Dprovider%26threadpool%3Dcached%26threads%3D300%26timestamp%3D1545779418058";
            ;
    public static void main(String[] args) {
       String[] arr = url.split("%");
       for( String str : arr ){
           System.out.println(str);
       }
    }
}
