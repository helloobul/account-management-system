/**
 * 
 */
package org.banking.account.repository;

import org.banking.account.entity.AccountHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@Repository
public interface AccountHistRepository extends JpaRepository<AccountHistory, Long> {

}
