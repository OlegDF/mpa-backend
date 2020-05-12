import org.hibernate.HibernateException
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.usertype.UserType
import java.io.Serializable
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Types

class StringArrayUserType : UserType {

    override fun nullSafeSet(st: PreparedStatement?, value: Any?, index: Int, session: SharedSessionContractImplementor?) {
        val connection = st?.connection
        val castObject = value as Array<String>
        val array = connection?.createArrayOf("integer", castObject)
        st?.setArray(index, array)
    }

    override fun nullSafeGet(rs: ResultSet?, names: Array<out String>?, session: SharedSessionContractImplementor?, owner: Any?): Any {
        val array = rs?.getArray(names?.get(0))
        val kotlinArray = array?.array as Array<String>
        return kotlinArray
    }

    @Throws(HibernateException::class)
    override fun assemble(cached: Serializable, owner: Any): Any {
        return cached
    }

    @Throws(HibernateException::class)
    override fun deepCopy(o: Any): Any {
        return if (o == null) o else (o as Array<String>).clone()
    }

    @Throws(HibernateException::class)
    override fun disassemble(o: Any): Serializable {
        return o as Serializable
    }

    @Throws(HibernateException::class)
    override fun equals(x: Any, y: Any): Boolean {
        return if (x == null) y == null else x == y
    }

    @Throws(HibernateException::class)
    override fun hashCode(o: Any): Int {
        return o?.hashCode() ?: 0
    }

    override fun isMutable(): Boolean {
        return false
    }

    @Throws(HibernateException::class)
    override fun replace(original: Any, target: Any, owner: Any): Any {
        return original
    }

    override fun returnedClass(): Class<Array<String>> {
        return Array<String>::class.java
    }

    override fun sqlTypes(): IntArray {
        return intArrayOf(SQLTYPE)
    }

    companion object {
        protected const val SQLTYPE = Types.ARRAY
    }
}