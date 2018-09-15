此文件存放可使此项目运行起来的数据库建表语句

<where>
            # 注意，第一个if处不需要加“and”，同时，除了第一个if外的其它if中都需要有“and”
            <if test="name != null">
                name=#{name}
            </if>
            # 注意，这里需要“and”
            <if test="age != null">
                and age=#{age}
            </if>
            # 注意，这里需要“and”
            <if test="address != null">
                and address=#{address}
            </if>
            # 注意，这里需要“and”
            <if test="id != null">
                and id=#{id}
            </if>
        </where>