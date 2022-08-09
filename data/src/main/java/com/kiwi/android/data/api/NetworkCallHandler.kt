package com.kiwi.android.data.api

import com.kiwi.android.core.DispatchersProvider
import com.kiwi.android.core.Logger
import com.kiwi.android.domain.model.NetworkException
import com.kiwi.android.domain.model.NetworkUnavailableException
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class NetworkCallHandler @Inject constructor(
    private val connectionManager: ConnectionManager,
    private val dispatchers: DispatchersProvider,
    private val logger: Logger
) {

    suspend fun <T> call(networkCall: suspend () -> T): Result<T> {
        return withContext(dispatchers.io()) {
            try {
                if (!connectionManager.isConnected())
                    Result.failure(NetworkUnavailableException())
                else
                    Result.success(networkCall())

            } catch (exception: HttpException) {
                logger.e(exception)
                Result.failure(NetworkException(exception.message ?: "Code ${exception.code()}"))
            } catch (t: Throwable) {
                logger.e(t)
                Result.failure(NetworkException("Unknown error occurred"))
            }
        }
    }

}