/**
 * 
 */
package org.banking.account.repository;

import org.banking.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ObulSubbaReddy Bhojja
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
