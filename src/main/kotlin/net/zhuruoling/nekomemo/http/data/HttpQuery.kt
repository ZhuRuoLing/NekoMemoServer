package net.zhuruoling.nekomemo.http.data

import kotlinx.serialization.Serializable
import net.zhuruoling.nekomemo.security.Session

enum class QueryActions(val action: Action<*>) {
    LIST_FILE(Action.LIST_FILE)
}


class Action<T>(clazz: Class<T>, val decoder: Session.(String) -> T){
    companion object{
        val LIST_FILE = Action(String::class.java) {
            if (this.keyStore.gotPublicKeyFromClient) {
                it
            } else {
                it
            }
        }
    }
}



@Serializable
data class HttpQueryData(val action: QueryActions, val content: String)

class HttpQueryContext(val session: Session)