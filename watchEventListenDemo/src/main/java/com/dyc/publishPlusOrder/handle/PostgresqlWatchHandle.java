package com.dyc.publishPlusOrder.handle;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */

import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.postgresqlModel.PostgresqlMonitorDTO;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */
public class PostgresqlWatchHandle extends AbstactWatchListen<PostgresqlMonitorDTO> {


    @Override
    public void connectExcessWarnning(PostgresqlMonitorDTO postgresqlMonitorDTO) {

    }

    @Override
    public void connectReject(PostgresqlMonitorDTO postgresqlMonitorDTO) {

    }
}
