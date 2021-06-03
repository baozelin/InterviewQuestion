package DropboxOA;

/**
 * requirement:
 * 1. users should able to upload and download files/photos
 * 2. able to sharer files or folders with other users
 * 3. support automatic synchronization between devices, after u updating a file on one device,
 * it should get synchronized on all devices.
 * 4. support storing a large files up to a GB
 * 5. ACID-ity required
 * 6. support offline editing. offline add/delete/modify file, as soon as they come online, all changes should synced
 *
 * rollback
 *
 * Consideration:
 * 1.huge read and write volumes
 * 2. files can be stored in small parts or chunks(4MB)
 * 3. reduce the amount if data exchange by transferring updated chunks only
 * 4. removing duplication chunks, save storage space
 * 5. keep local copy of the metadata
 *
 *
 * Constraints:
 * 1. 500M users, 100M daily active users
 * 2. average each user connect from three different device
 * 3. average a user has 200 files/photos, 100 billion total files
 * 4. average file size is 100KB, ten petabytes of total storage
 * 5. one million active connection per minute
 */


/**
 * client
 *
 * operation:
 *  1. upload and download files
 *  2. detct file changes in the workspace folder
 *  3. handle conflict due to offline or concurrent updates
 *
 *
 *  how do we handle file transfer efficiently?
 *  we can break each file in to smaller chuncks so that we transfer only those chunks which are modified, and not the
 *  whole file. we divide each file into fixed size of 4MB chunks.( based on storage devices we use in the cloud,
 *  opttimize space utilization and input/output operatioins per second, average file size. We should also keep a record
 *  of each file and chunks in metadata.
 *
 *  we should keep a copy of a metadata with client: 1. users can do offline updates, 2. save a lot of time to update remote
 *  metadata.
 *
 *  how can client efficiently listen to changes happening on other clients?
 *  One solution that the clients periodically check with the server if there are any changes (per 10 s). 问题是，we will
 *  have a delay in reflecting changes, also waste time to pull.
 *
 */
public class Dropbox {
}
