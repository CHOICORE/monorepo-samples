package me.choicore.samples.monorepo.infrastructure.exposed.table

import org.jetbrains.exposed.dao.id.LongIdTable

object TestTable : LongIdTable(name = "test", columnName = "test_id")
